package com.jw.util;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.os.Environment;

public class FileUtil {

	public static final String SD_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	public static final String RES_ROOT = SD_PATH + "/" + "fitter";

	public static final String IMAGE_DIR = RES_ROOT + "/" + "img";

	private static String mPhotoFilePath;

	@SuppressLint("SimpleDateFormat")
	public static File getPortraitFile() {
		makeRootDir();
		String fname = new SimpleDateFormat("yyMMddHHmmss").format(new Date() ) + ".jpg";
		File photoFile = new File(IMAGE_DIR + "/" + fname);
		mPhotoFilePath = photoFile.getAbsolutePath();
		return photoFile;

	}


	public static String getPhotoFilePath() {
		return mPhotoFilePath;
	}

	public static void makeRootDir() {
		File resRoot = new File(RES_ROOT);
		if (!resRoot.exists()) {
			resRoot.mkdir();
			L.red("res_root not exist mkdir");
		}

		File imageDir = new File(IMAGE_DIR);
		if (!imageDir.exists()) {
			imageDir.mkdir();
			L.red("publish_dir not exist mkdir");
		}
	}
}
