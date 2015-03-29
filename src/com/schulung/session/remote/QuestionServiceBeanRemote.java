/**
 * Copyright (c) Dell Services 2014.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary
 * information of Dell Services ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered
 * into with Dell Services.
 * Unauthorized reproduction or distribution of this Confidential Information,
 * or any portion of it, may result in severe civil and criminal penalties.
*/
package com.schulung.session.remote;

import javax.ejb.Remote;

import com.schulung.session.common.QuestionServiceBeanCommon;


/**
 * 
 * @author Robert_Moldovan
 *
 */

@Remote
public interface QuestionServiceBeanRemote extends QuestionServiceBeanCommon{
}
