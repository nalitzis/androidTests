package com.androidviews;

import java.net.URI;

public class Cell {
	
	private URI mImageViewUri;
	private String mText;
	
	Cell(URI imageViewUri, String text) {
		mImageViewUri = imageViewUri;
		mText = text;
	}
	
	public String getText() {
		return mText;
	}
	
	public URI getImageViewUri() {
		return mImageViewUri;
	}

}
