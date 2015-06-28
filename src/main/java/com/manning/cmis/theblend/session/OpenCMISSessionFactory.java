/**
 * Copyright 2012 Manning Publications Co.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.manning.cmis.theblend.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Repository;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class OpenCMISSessionFactory {

	/**
	 * Creates a new OpenCMIS session with the provided username and
	 * password.
	 * @param username
	 * @param password
	 * @return 
	 */
	public static Session createOpenCMISSession(String username, String password) {
		Map<String, String> parameter = new HashMap<>();

		parameter.put(SessionParameter.USER, username);
		parameter.put(SessionParameter.PASSWORD, password);

		parameter.put(SessionParameter.ATOMPUB_URL, "http://localhost:8081/cmisatom11");
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameter.put(SessionParameter.REPOSITORY_ID, "A1");

		SessionFactory factory = SessionFactoryImpl.newInstance();

		List<Repository> repositories = factory.getRepositories(parameter);
		for (Repository r : repositories) {
			System.out.println("Found repository: " + r.getName());
		}

		return factory.createSession(parameter);
	}

	/**
	 * Returns the application root folder.
	 * @return 
	 */
	public static String getApplicationRootFolderPath() {
		return "/blend";
	}

}
