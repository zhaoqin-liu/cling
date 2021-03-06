/*
 * Copyright (C) 2013 4th Line GmbH, Switzerland
 *
 * The contents of this file are subject to the terms of either the GNU
 * Lesser General Public License Version 2 or later ("LGPL") or the
 * Common Development and Distribution License Version 1 or later
 * ("CDDL") (collectively, the "License"). You may not use this file
 * except in compliance with the License. See LICENSE.txt for more
 * information.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package org.fourthline.cling.demo.osgi.device.light.actions;

import org.fourthline.cling.demo.osgi.device.light.variables.LoadLevelTargetStateVariable;
import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPStateVariable;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruce Green
 */
public class SetLoadLevelTargetAction implements UPnPAction {

    private Map<String, UPnPStateVariable> variables = new HashMap<String, UPnPStateVariable>();

    final private String NEW_LOAD_LEVEL_TARGET = "NewLoadLevelTarget";
    final private String[] IN_ARG_NAMES = new String[]{NEW_LOAD_LEVEL_TARGET};

    public SetLoadLevelTargetAction(LoadLevelTargetStateVariable loadLevelTargetStateVariable) {
        variables.put(NEW_LOAD_LEVEL_TARGET, loadLevelTargetStateVariable);
    }

    @Override
    public String getName() {
        return "SetLoadLevelTarget";
    }

    @Override
    public String getReturnArgumentName() {
        return null;
    }

    @Override
    public String[] getInputArgumentNames() {
        return IN_ARG_NAMES;
    }

    @Override
    public String[] getOutputArgumentNames() {
        return null;
    }

    @Override
    public UPnPStateVariable getStateVariable(String argumentName) {
        return variables.get(argumentName);
    }

    @Override
    public Dictionary invoke(Dictionary args) throws Exception {
        Integer state = (Integer) args.get(NEW_LOAD_LEVEL_TARGET);

        if (state == null) {
        } else {
            LoadLevelTargetStateVariable dimmer =
                    (LoadLevelTargetStateVariable) variables.get(NEW_LOAD_LEVEL_TARGET);
            dimmer.setCurrentValue(state);
        }

        return null;
    }

}
