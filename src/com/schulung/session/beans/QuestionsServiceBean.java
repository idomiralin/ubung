package com.schulung.session.beans;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.schulung.session.common.QuestionServiceBeanCommon;
import com.schulung.session.local.QuestionServiceBeanLocal;
import com.schulung.session.remote.QuestionServiceBeanRemote;


@Stateless
@Local(QuestionServiceBeanLocal.class)
@Remote(QuestionServiceBeanRemote.class)
public class QuestionsServiceBean implements QuestionServiceBeanCommon{

	@Override
	public String getQuestion(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
