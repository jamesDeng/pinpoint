package com.navercorp.pinpoint.web.alarm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import com.navercorp.pinpoint.web.service.UserGroupService;

public class AlarmMessageSenderImple implements AlarmMessageSender {

	@Autowired
	private UserGroupService userGroupService;
	
	private static final Logger logger=LoggerFactory.getLogger(AlarmMessageSenderImple.class);

	@Override
	public void sendSms(AlarmChecker checker, int sequenceCount) {
		List<String> receivers = userGroupService.selectPhoneNumberOfMember(checker.getuserGroupId());

		if (receivers.size() == 0) {
			return;
		}
		List<String> msgList=checker.getSmsMessage();
		
		for (String message : msgList) {
			logger.info("send email : {}", message);
		}
	}

	@Override
	public void sendEmail(AlarmChecker checker, int sequenceCount) {
		List<String> receivers = userGroupService.selectPhoneNumberOfMember(checker.getuserGroupId());

		if (receivers.size() == 0) {
			return;
		}
		List<String> msgList=checker.getSmsMessage();
		
		for (String message : msgList) {
			logger.info("send email : {}", message);
		}
	}

}
