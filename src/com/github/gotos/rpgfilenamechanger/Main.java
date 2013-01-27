package com.github.gotos.rpgfilenamechanger;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.naming.event.EventContext;

import com.github.gotos.rpgreader.engine.DataReader;
import com.github.gotos.rpgreader.engine.LuciferCommonEvent;
import com.github.gotos.rpgreader.engine.LuciferDatabase;
import com.github.gotos.rpgreader.engine.LuciferHeroUnit;

/**
 * Main Class, the class that will be started.
 * 
 * @author alina
 *
 */
public class Main {

	
	private Main() { }
	
	/**
	 * This will start everything, eventually. For now, it takes two parameters, as stated below, and renames only charsets.
	 * 
	 * @param args pathToProject oldFilename, newFilename
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java Main pathToProject oldFilename newFilename");
			System.exit(1);
		}
		String path = null;
		for (String folder : new File(args[0]).list()) {
			if (folder.equalsIgnoreCase("charset")) {
				path = args[0] + "/" + folder;
			}
		}
		if (path == null) {
			System.out.println("No Charset-folder found in project.");
			System.exit(2);
		}
		File oldFile = null;
		for (String filename : new File(path).list()) {
			if (filename.toLowerCase().startsWith(args[1].toLowerCase())) {
				oldFile = new File(path + "/" + filename);
			}
		}
		if (oldFile == null) {
			System.out.println("oldFile does not exist!");
			System.exit(3);
		}
		String extension = oldFile.getPath().substring(oldFile.getPath().lastIndexOf("."));
		File newFile = new File(path + "/" + args[2] + extension);
		if (newFile.exists()) {
			System.out.println("newFile already exist! Exiting...");
			System.exit(4);
		}
		
		//get db
		DataReader dbdr;
		for (String filename : new File(path).list()) {
			if (filename.equalsIgnoreCase("rpg_rt.ldb")) {
				dbdr = DataReader.parseFile(path + "/" + filename);
				try {
					dbdr.nextUnitZeroID();
					LuciferDatabase db = new LuciferDatabase(dbdr);
					for (LuciferHeroUnit hero : db.getHeroes()) {
						if (hero.getGraphicFile().equalsIgnoreCase(args[1])) {
							hero.setGraphicFile(args[2]);
						}
					}
				} catch (IOException e) {
					System.out.println("Database broken!");
					System.exit(5);
				}
				
			}
		}
		
		//rename file
		oldFile.renameTo(newFile);
	}
}
