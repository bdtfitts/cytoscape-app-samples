package org.cytoscape;
import org.junit.Test;
import org.junit.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URISyntaxException;
public class FileExportTest {
	@SuppressWarnings("unused")
	@Test
	public void oneNodeTest() {
		URL expectedURL = getClass().getResource("/expectedOneNode.dot");
		URL actualURL = getClass().getResource("/actualOneNode.dot");
		File expected = null;
		File actual = null;
		try {
			expected = new File(expectedURL.toURI());
			actual = new File(actualURL.toURI());
		} catch (URISyntaxException e) {
			Assert.fail();
		}
		BufferedReader expectedRdr = null;
		BufferedReader actualRdr = null;
		try {
			expectedRdr = new BufferedReader(new FileReader(expected));
			actualRdr = new BufferedReader(new FileReader(actual));
		} catch (FileNotFoundException e) {
			Assert.fail("Test files not found");
		}
		if (expectedRdr == null || actualRdr == null) {
			Assert.fail();
		}
		try {
			String expectedLine = expectedRdr.readLine();
			String actualLine = actualRdr.readLine();
			
			while (expectedLine != null && actualLine != null) {
				Assert.assertEquals("Outputs not the same", expectedLine, actualLine);
				expectedLine = expectedRdr.readLine();
				actualLine = actualRdr.readLine();
			}
			Assert.assertEquals(null, expectedLine);
			Assert.assertEquals(null, actualLine);
		} catch (IOException e) {
			Assert.fail("Unable to read files");
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void threeNodeTest() {
		URL expectedURL = getClass().getResource("/expectedThreeNode.dot");
		URL actualURL = getClass().getResource("/actualThreeNode.dot");
		File expected = null;
		File actual = null;
		try {
			expected = new File(expectedURL.toURI());
			actual = new File(actualURL.toURI());
		} catch (URISyntaxException e) {
			Assert.fail();
		}
		BufferedReader expectedRdr = null;
		BufferedReader actualRdr = null;
		try {
			expectedRdr = new BufferedReader(new FileReader(expected));
			actualRdr = new BufferedReader(new FileReader(actual));
		} catch (FileNotFoundException e) {
			Assert.fail("Test files not found");
		}
		if (expectedRdr == null || actualRdr == null) {
			Assert.fail();
		}
		try {
			String expectedLine = expectedRdr.readLine();
			String actualLine = actualRdr.readLine();
			
			while (expectedLine != null && actualLine != null) {
				Assert.assertEquals("Outputs not the same", expectedLine, actualLine);
				expectedLine = expectedRdr.readLine();
				actualLine = actualRdr.readLine();
			}
			Assert.assertEquals(null, expectedLine);
			Assert.assertEquals(null, actualLine);
		} catch (IOException e) {
			Assert.fail("Unable to read files");
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void threeConnNodeTest() {
		URL expectedURL = getClass().getResource("/expectedThreeConnNode.dot");
		URL actualURL = getClass().getResource("/actualThreeConnNode.dot");
		File expected = null;
		File actual = null;
		try {
			expected = new File(expectedURL.toURI());
			actual = new File(actualURL.toURI());
		} catch (URISyntaxException e) {
			Assert.fail();
		}
		BufferedReader expectedRdr = null;
		BufferedReader actualRdr = null;
		try {
			expectedRdr = new BufferedReader(new FileReader(expected));
			actualRdr = new BufferedReader(new FileReader(actual));
		} catch (FileNotFoundException e) {
			Assert.fail("Test files not found");
		}
		if (expectedRdr == null || actualRdr == null) {
			Assert.fail();
		}
		try {
			String expectedLine = expectedRdr.readLine();
			String actualLine = actualRdr.readLine();
			
			while (expectedLine != null && actualLine != null) {
				Assert.assertEquals("Outputs not the same", expectedLine, actualLine);
				expectedLine = expectedRdr.readLine();
				actualLine = actualRdr.readLine();
			}
			Assert.assertEquals(null, expectedLine);
			Assert.assertEquals(null, actualLine);
		} catch (IOException e) {
			Assert.fail("Unable to read files");
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void sixNodeTwoGroupTest() {
		URL expectedURL = getClass().getResource("/expectedSixNode.dot");
		URL actualURL = getClass().getResource("/actualSixNode.dot");
		File expected = null;
		File actual = null;
		try {
			expected = new File(expectedURL.toURI());
			actual = new File(actualURL.toURI());
		} catch (URISyntaxException e) {
			Assert.fail();
		}
		BufferedReader expectedRdr = null;
		BufferedReader actualRdr = null;
		try {
			expectedRdr = new BufferedReader(new FileReader(expected));
			actualRdr = new BufferedReader(new FileReader(actual));
		} catch (FileNotFoundException e) {
			Assert.fail("Test files not found");
		}
		if (expectedRdr == null || actualRdr == null) {
			Assert.fail();
		}
		try {
			String expectedLine = expectedRdr.readLine();
			String actualLine = actualRdr.readLine();
			
			while (expectedLine != null && actualLine != null) {
				Assert.assertEquals("Outputs not the same", expectedLine, actualLine);
				expectedLine = expectedRdr.readLine();
				actualLine = actualRdr.readLine();
			}
			Assert.assertEquals(null, expectedLine);
			Assert.assertEquals(null, actualLine);
		} catch (IOException e) {
			Assert.fail("Unable to read files");
		}
	}
}