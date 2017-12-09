package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pluralsight.model.Share;

@Service("shareService")
public class ShareServiceImpl implements ShareService {

	public List<Share> findAllShares() {
		
		List<Share> shares = new ArrayList<Share>();
		
		Share bzwbk = new Share();
		bzwbk.setName("BZWBK");
		shares.add(bzwbk);
		
		Share pkopb = new Share();
		pkopb.setName("PKOBP");
		shares.add(pkopb);
		
		Share kghm = new Share();
		kghm.setName("KGHM");
		shares.add(kghm);
		
		return shares;
	}
}
