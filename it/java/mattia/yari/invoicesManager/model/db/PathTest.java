package it.java.mattia.yari.invoicesManager.model.db;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathTest {

	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath(first, more);
		
		System.out.println(path);
		
	}

}
