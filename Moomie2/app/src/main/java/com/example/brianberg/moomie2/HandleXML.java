package com.example.brianberg.moomie2;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jerry on 4/4/2016.
 * Parses the xml from the OMDBAPI
 */
public class HandleXML {
    private String id = "imdbID";
    private String title = "title";
    private String plot = "plot";
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public HandleXML(String url) {
        this.urlString = url;
    }

    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlot() {
        return plot;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;

        try {
            event = myParser.getEventType();
            Log.d("Parser","Started Parser");

            while (event != XmlPullParser.END_DOCUMENT) {

                String name = myParser.getName();
                Log.d("Parser","loop");

                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (name.equals("movie")){
                            Log.d("OMDB","reading wrong things");
                            id = myParser.getAttributeValue(17);
                            title = myParser.getAttributeValue(0);
                            plot = myParser.getAttributeValue(9);
                        } else {

                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        Log.d("OMDB","READING TEXT");
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchXML() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                    conn.setReadTimeout(10000 /*milliseconds*/);
                    conn.setConnectTimeout(15000 /*milliseconds*/);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();

                    Log.d("Network:","Connected to OMDB");

                    InputStream stream = conn.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);

                    parseXMLAndStoreIt(myparser);
                    Log.d("Parser","parseXMLAndStoreIt");
                    stream.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
