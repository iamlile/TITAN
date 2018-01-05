/*
 * Copyright (C) 2015-2020 yunjiweidian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.yunji.titan.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc titan-monitor 启动函数
 *
 * @author liuliang
 *
 */
public class Main {
	private Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		new Main();
	}

	@SuppressWarnings("resource")
	Main() {
		new ClassPathXmlApplicationContext("classpath:*-context.xml");
		logger.info("titan-monitor启动成功...");
		try {
			synchronized (this) {
				this.wait();
			}
		} catch (Exception e) {
			logger.error("error", e);
		}
	}
}