package com.digital.controller;

/**
 * @author jiayin.wang
 * @date 2017-07-27
 */
public interface ControllerConstants
{
	/**
	 *
	 */
	interface Navigations
	{
		String HOME = "home";
		String USER = "user";
		String BOOK = "book";
		String ABOUT = "about";
		String CONTACT = "contact";
	}

	/**
	 *
	 */
	interface Views
	{
		interface Pages
		{
			interface Titles
			{
				String HOME = "BMS Home Page";
				String USER = "BMS User Management Page";
				String BOOK = "BMS Book Management Page";
				String ABOUT = "BMS About Page";
				String CONTACT = "BMS Contact Page";
			}

			interface Names
			{
				String HOME = "home";
				String USER = "user";
				String BOOK = "book";
				String ABOUT = "about";
				String CONTACT = "contact";
			}
		}

		interface Templates
		{
			interface Home
			{
				String TEMPLATE = "fragment/home";
				String FRAGMENT_BRIEF = "brief";
			}

			interface User
			{
				String TEMPLATE_QUERY = "fragment/queryUser";
				String TEMPLATE_CREATE = "fragment/createUser";
				String TEMPLATE_UPDATE = "fragment/updateUser";
				String FRAGMENT_COPY = "copy";
			}

			interface Book
			{
				String TEMPLATE = "fragment/book";
				String FRAGMENT_COPY = "copy";
			}
		}
	}
}
