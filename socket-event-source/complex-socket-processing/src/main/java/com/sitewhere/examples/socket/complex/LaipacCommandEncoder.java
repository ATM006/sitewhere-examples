/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.examples.socket.complex;

import org.apache.log4j.Logger;

import com.sitewhere.server.lifecycle.LifecycleComponent;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.IDeviceNestingContext;
import com.sitewhere.spi.device.command.IDeviceCommandExecution;
import com.sitewhere.spi.device.command.ISystemCommand;
import com.sitewhere.spi.device.communication.ICommandExecutionEncoder;
import com.sitewhere.spi.server.lifecycle.LifecycleComponentType;

/**
 * Encodes specification commands for Laipac devices into the SMS commands expected by the
 * devices.
 * 
 * @author Derek
 */
public class LaipacCommandEncoder extends LifecycleComponent implements ICommandExecutionEncoder<String> {

	/** Static logger instance */
	private static Logger LOGGER = Logger.getLogger(LaipacCommandEncoder.class);

	public LaipacCommandEncoder() {
		super(LifecycleComponentType.CommandExecutionEncoder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#start()
	 */
	@Override
	public void start() throws SiteWhereException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#getLogger()
	 */
	@Override
	public Logger getLogger() {
		return LOGGER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#stop()
	 */
	@Override
	public void stop() throws SiteWhereException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.spi.device.communication.ICommandExecutionEncoder#encode(com.sitewhere
	 * .spi.device.command.IDeviceCommandExecution,
	 * com.sitewhere.spi.device.IDeviceNestingContext,
	 * com.sitewhere.spi.device.IDeviceAssignment)
	 */
	@Override
	public String encode(IDeviceCommandExecution command, IDeviceNestingContext nested,
			IDeviceAssignment assignment) throws SiteWhereException {
		return "TEST," + command.getCommand().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.spi.device.communication.ICommandExecutionEncoder#encodeSystemCommand
	 * (com.sitewhere.spi.device.command.ISystemCommand,
	 * com.sitewhere.spi.device.IDeviceNestingContext,
	 * com.sitewhere.spi.device.IDeviceAssignment)
	 */
	@Override
	public String encodeSystemCommand(ISystemCommand command, IDeviceNestingContext nested,
			IDeviceAssignment assignment) throws SiteWhereException {
		return "This is a test command.";
	}
}