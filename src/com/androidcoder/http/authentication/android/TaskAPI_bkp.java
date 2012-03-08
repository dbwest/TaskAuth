package com.androidcoder.http.authentication.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

class APIConnection {	
	
	
	
	void initConnection () {
		CredentialsProvider credProvider = new BasicCredentialsProvider();
        credProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
            new UsernamePasswordCredentials("david.b.west@gmail.com", "29ef533ef18c"));
    	StringBuilder builder = new StringBuilder();
		DefaultHttpClient client = new DefaultHttpClient();
		client.setCredentialsProvider(credProvider);
		
		
	}
}

class APICall  {
	
	APIConnection myConn = new APIConnection();
	
	public String getUser () {
		final DefaultHttpClient client;
		initConnection();
		HttpGet httpGet = new HttpGet(
				"https://www.taskforceapp.com/api/v1/user.json");
		try {
			//DefaultHttpClient client = ConnectAPI.initConnection().client;
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(AndroidHttpAuthentication.class.toString(), "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	//__construct
	public String createUser () {
		
	}
	public String getTasks () {
		
	}
	public String getTask () {
		
	}
	public String getLists () {
		
	}
	public String getList () {
		
	}
	public String countTasks () {
		
	}
	public String createTask () {
		
	}
	public String createList () {
		
	}
	public String addCollaborator () {
		
	}
}