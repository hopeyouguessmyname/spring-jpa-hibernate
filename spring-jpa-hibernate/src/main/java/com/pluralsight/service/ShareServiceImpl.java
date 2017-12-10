package com.pluralsight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Share;

@Service("shareService")
public class ShareServiceImpl implements ShareService {

	public List<Share> findAllShares() {
		
		List<Share> shares = new ArrayList<Share>();
		try {
			Document doc = Jsoup.connect("https://www.gpw.pl/wskazniki").get();			
			Element body = doc.body();
			List<Element> list = body.getElementsByClass("left");
			
//			String code = "";
//			String name = "";
			int index = 1;
			for(int i = 3; i < list.size(); i++)
			{
//				if(i % 3 == 0) {
//					code = list.get(i).text();
//				}
//				if(i % 3 == 1) {
//					name = list.get(i).text();
//				}
				
				if(i % 3 == 1) {
					Share share = new Share();
//					share.setCode(code);
					share.setAbbreviation(Integer.toString(index) + " " + list.get(i).text());
					shares.add(share);
					if(list.get(i).text().equals("ZYWIEC"))
						break;
					index++;
				}
			}
		}
		catch (IOException exp) {
			System.out.println(exp.getMessage());
		}
		
		return shares;
	}
}
