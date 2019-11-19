package com.ovs.fingerPrint;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;

class node {
	public ArrayList<Integer> neighbooringCellIndices = new ArrayList<Integer>();
	public int X, Y, Theta, Type;

	public node(int X, int Y, int Type) {
		this.X = X;
		this.Y = Y;
		this.Type = Type;
	}
}

public class FR3 {

	/**
	 * Greyscale & Binarizing
	 * 
	 * @param img
	 *            Image to be binarized based on the greyscaling at
	 * @see http
	 *      ://manthapavankumar.wordpress.com/2012/12/16/converting-a-color-image
	 *      -to-a-grayscale-image-programatically-using-java/
	 */
	public static int[][] binarizing(BufferedImage img) throws Exception {
		int i, j, avg = 0;
		System.out.println("width of image " + img.getWidth());
		System.out.println("height of image " + img.getHeight());
		int img_bin[][] = new int[img.getWidth()][img.getHeight()];
		BufferedImage greyscale = new BufferedImage(img.getWidth(),
				img.getHeight(), img.getType());
		Color c;
		for (i = 0; i < img.getWidth(); i++)
			for (j = 0; j < img.getHeight(); j++) {
				c = new Color(img.getRGB(i, j));

				avg = c.getRed() + c.getGreen() + c.getBlue();
				avg /= 3;
				if (avg > 120)
					img_bin[i][j] = 1;
				else
					img_bin[i][j] = 0;

				greyscale.setRGB(i, j, new Color(avg, avg, avg).getRGB());
			}
		ImageIO.write(greyscale, "png", new File("greyscale.png"));
		return img_bin;
	}

	public static int[][] getFastParallelAlgoSkeleton(int img_bin[][])
			throws Exception {
		int i, j, k, A, B;
		// clockwise
		int di[] = new int[] { 0, 0, -1, -1, 0, 1, 1, 1, 0, -1 };// 1st 2
																	// elements
																	// are
																	// useless
		int dj[] = new int[] { 0, 0, 0, 1, 1, 1, 0, -1, -1, -1 };
		boolean EVEN = true;

		BufferedImage debugImg = new BufferedImage(img_bin.length,
				img_bin[0].length, BufferedImage.TYPE_INT_ARGB);

		int skeleton[][] = new int[img_bin.length][img_bin[0].length];
		for (i = 1; i < img_bin.length - 1; i++)
			for (j = 1; j < img_bin[i].length - 1; j++) {
				skeleton[i][j] = 0;
				A = img_bin[i][j];
				B = 0;
				for (k = 2; k <= 9; k++)
					// from P2+P3+...+P9
					B += img_bin[i + di[k]][j + dj[k]];

				// A=1 AND 3<= B <=6?
				if (A == 1 && 3 <= B && B <= 6) {
					if (!EVEN
							&& img_bin[i + di[2]][j + dj[2]]
									* img_bin[i + di[4]][j + dj[4]]
									* img_bin[i + di[6]][j + dj[6]] == 0
							&& img_bin[i + di[4]][j + dj[4]]
									* img_bin[i + di[6]][j + dj[6]]
									* img_bin[i + di[8]][j + dj[8]] == 0)

						skeleton[i][j] = 1;

					if (EVEN
							&& img_bin[i + di[2]][j + dj[2]]
									* img_bin[i + di[4]][j + dj[4]]
									* img_bin[i + di[8]][j + dj[8]] == 0
							&& img_bin[i + di[2]][j + dj[2]]
									* img_bin[i + di[6]][j + dj[6]]
									* img_bin[i + di[8]][j + dj[8]] == 0)

						skeleton[i][j] = 1;

				}

				if (skeleton[i][j] == 0)
					debugImg.setRGB(i, j, new Color(255, 255, 255).getRGB());
				else
					debugImg.setRGB(i, j, new Color(0, 0, 0).getRGB());

				EVEN = !EVEN;
			}

		ImageIO.write(debugImg, "png", new File("thin.png"));
		return skeleton;
	}

	public static int[][] getCN(int skeleton[][])// after thinning
	{
		int di[] = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
		int dj[] = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };

		int i, j, k;

		int trimL = skeleton[0].length - 1;
		int trimT = skeleton.length - 1;
		for (i = 0; i < skeleton.length; i++)
			for (j = 0; j < skeleton[0].length; j++)
				if (skeleton[i][j] > 0) {
					trimT = Math.min(trimT, i);
					trimL = Math.min(trimL, j);
				}

		int CN[][] = new int[skeleton.length - trimT][skeleton[0].length
				- trimL];

		for (i = trimT; i < skeleton.length - 1; i++)
			for (j = trimL; j < skeleton[0].length - 1; j++) {
				CN[i - trimT][j - trimL] = 0;
				for (k = 1; k < 8; k++)
					CN[i - trimT][j - trimL] += Math
							.abs(skeleton[i + di[k - 1]][j + dj[k - 1]]
									- skeleton[i + di[k]][j + dj[k]]);
			}
		// for(i=0;i<skeleton.length-trimT;i++)
		// {
		// for(j=0;j<skeleton[0].length-trimL;j++)
		// {
		// System.out.print(CN[i][j]);
		// }
		// System.out.println();
		// }
		return CN;

	}

	@SuppressWarnings("unchecked")
	public static node[] genGraph(int CN[][]) {
		ArrayList<node> graph = new ArrayList<node>();
		int i, j, k, currentIndex = -1;

		for (i = 0; i < CN.length; i++)
			for (j = 0; j < CN[0].length; j++)
				if (CN[i][j] > 0) {
					currentIndex = graph.size() - 1;
					if (graph.size() == 0)
						currentIndex = 0;

					graph.add(new node(i, j, CN[i][j]));
					// TODO: Heap out of memory fix
					for (k = 0; k < CN.length || k < CN[i].length; k++) // K is
																		// the
																		// distance
																		// between
																		// center
																		// point
																		// &
																		// neighbooring
																		// cell(s)
					{
						if (i + k < CN.length && CN[i + k][j] > 0) {
							graph.get(currentIndex).neighbooringCellIndices
									.add(graph.size());
							graph.add(new node(i + k, j, CN[i + k][j]));
						}
						if (j + k < CN[0].length && CN[i][j + k] > 0) {
							// graph.get(index)
							graph.get(currentIndex).neighbooringCellIndices
									.add(graph.size());
							graph.add(new node(i, j + k, CN[i][j + k]));
						}
					}
				}

		System.out.println("graph size" + graph.size());
		node GraphNodes[] = new node[graph.size()];
		graph.toArray(GraphNodes);
		/*
		 * for(int z=0;z<GraphNodes.length;z++){
		 * System.out.println("X "+GraphNodes
		 * [z].X+" Y "+GraphNodes[z].Y+" Type"+GraphNodes[z].Type); }
		 */
		return GraphNodes;
	}

	public static int compare(node[] graph1, node[] graph2) {
		System.out.println("in compare");
		// boolean equals = graph1.equals(graph2);

		int MinimumDistance = Integer.MAX_VALUE;

		Queue<Integer> Q = new LinkedList<Integer>();
		int i, j, currentNode1 = 0, currentNode2 = 0, distance_X, distance_Y, distance_sqrt;

		boolean used[] = new boolean[graph2.length]; // not sure about this
		Arrays.fill(used, false);

		currentNode1 = 0;

		Q.add(currentNode1);

		int flag = 0;
		while (!Q.isEmpty()) {
			currentNode1 = Q.remove();

			for (i = 0; i < graph2.length; i++)
				if (graph1[currentNode1].Type == graph2[i].Type
						&& used[i] == false) {
					distance_X = Math.abs(graph1[currentNode1].X - graph2[i].X);
					distance_Y = Math.abs(graph1[currentNode1].Y - graph2[i].Y);
					distance_sqrt = (int) Math.sqrt(distance_X * distance_X
							+ distance_Y * distance_Y);// (distance_X+distance_Y)/2;
					MinimumDistance = Math.min(MinimumDistance, distance_sqrt);
					if (i >= 9999) {
						flag = 1;
						break;
					}
					System.out.println(i + " distance bet X " + distance_X
							+ " distance bet Y " + distance_Y
							+ " distance_avg: " + distance_sqrt
							+ " MinimumDistance: " + MinimumDistance);
					used[i] = true;
				}
			Q.add(currentNode1 + 1);
			if (flag == 1)
				break;
		}
		return MinimumDistance;
	}

	/*
	 * public static int compare(node[] graph1,node[] graph2) {
	 * System.out.println("in compare "); int
	 * MinimumDistance=Integer.MAX_VALUE,missing=0;
	 * System.out.println("Minimum Distance max value: "+MinimumDistance);
	 * Queue<Integer> Q=new LinkedList<Integer>(); int
	 * i,j,currentBest,currentCost
	 * ,currentNode1=0,currentNode2=0,TotalDifference=0;
	 * 
	 * boolean used[]=new boolean[graph2.length]; //
	 * System.out.println("graph2 length "+graph2.length); Arrays.fill(used,
	 * false);
	 * 
	 * currentNode1=0; TotalDifference=0;
	 * 
	 * Q.add(currentNode1); // System.out.println("Q add "+currentNode1);
	 * Q.add(TotalDifference);
	 * 
	 * while(!Q.isEmpty()) { currentNode1=Q.remove();
	 * TotalDifference=Q.remove();
	 * 
	 * currentCost=1<<30;
	 * 
	 * currentBest=-1;
	 * 
	 * if(currentNode1==graph1.length-1) {
	 * MinimumDistance=Math.min(MinimumDistance,TotalDifference); break; }
	 * 
	 * // System.out.println("graph2_length "+graph2.length);
	 * for(i=0;i<graph2.length;i++) //
	 * System.out.println(+(Math.abs(graph1[currentNode1].X-graph2[i].X)+ //
	 * Math.abs(graph1[currentNode1].Y-graph2[i].Y))); //
	 * System.out.println("graph1_type "+graph1[currentNode1].Type); //
	 * System.out.println("graph2_type "+graph2[i].Type);
	 * if(graph1[currentNode1].Type== graph2[i].Type && used[i]==false &&
	 * (Math.abs(graph1[currentNode1].X-graph2[i].X)+
	 * Math.abs(graph1[currentNode1].Y-graph2[i].Y))<=currentCost) { //TODO:
	 * branching should be here, but returns Heap out of memory,so, is picking
	 * the closest 1 w same type fine?!
	 * 
	 * currentCost=(Math.abs(graph1[currentNode1].X-graph2[i].X)+
	 * Math.abs(graph1[currentNode1].Y-graph2[i].Y)); //
	 * System.out.println("current cost "+currentCost); currentBest=i; } //
	 * System.out.println("current best "+currentBest); if(currentBest>-1) { //
	 * System.out.println("in if currentBest"); used[currentBest]=true;
	 * 
	 * Q.add(currentNode1+1); Q.add(TotalDifference+currentCost); } else {
	 * //System.out.println("in else"); missing++; Q.add(currentNode1+1);
	 * Q.add(TotalDifference); }
	 * System.out.println(" distance "+MinimumDistance); }
	 * System.out.println("Skipped="+missing);
	 * System.out.println("minimum dstance "+MinimumDistance); return
	 * MinimumDistance; }
	 */

	public static boolean validateFingerPrint(String voterId, String path)
			throws Exception {
		System.out.println("in main");
		int i;
		// String voterid="DSC_0255";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			PreparedStatement ps = con
					.prepareStatement("select * from FINGERPRINT WHERE voterid = '"
							+ voterId + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob b = rs.getBlob(2);
				byte barr[] = b.getBytes(1, (int) b.length());

				FileOutputStream fout = new FileOutputStream("C:\\Users\\hp hp\\Desktop\\samples\\"
						+ voterId + ".png");
				fout.write(barr);

				fout.close();
			}
			System.out.println("ok");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageTest imgt = new ImageTest();

		try {

			BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\hp hp\\Desktop\\samples\\"
					+ voterId + ".png"));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();
			if (originalImage.getHeight() > 1000
					|| originalImage.getWidth() > 1000) {
				BufferedImage resizeImagePng = ImageTest.resizeImage(originalImage, type);
				ImageIO.write(resizeImagePng, "png", new File("C:\\Users\\hp hp\\Desktop\\samples\\"
						+ voterId + ".png"));
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		node[] graph1 = genGraph(getCN(getFastParallelAlgoSkeleton(binarizing(ImageIO
				.read(new File("C:\\Users\\hp hp\\Desktop\\samples\\" + voterId + ".png"))))));

		try {

			BufferedImage originalImage = ImageIO.read(new File(path));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();
			if (originalImage.getHeight() > 1000
					|| originalImage.getWidth() > 1000) {
				BufferedImage resizeImagePng = imgt.resizeImage(originalImage,
						type);
				ImageIO.write(resizeImagePng, "png", new File(path));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		boolean votersuccessfull = false;
		int Result = compare(graph1,
				genGraph(getCN(getFastParallelAlgoSkeleton(binarizing(ImageIO
						.read(new File(path)))))));
		if (Result <= 11) {
			votersuccessfull = true;
			System.out.println("Congratulations, You can proceed to vote");
		} else {
			votersuccessfull = false;
			System.out.println("Sorry! Invalid User");
		}
		return votersuccessfull;
	}

}
