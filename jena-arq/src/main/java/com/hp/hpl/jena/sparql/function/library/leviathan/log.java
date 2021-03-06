/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.hpl.jena.sparql.function.library.leviathan;

import java.util.List;

import com.hp.hpl.jena.query.QueryBuildException;
import com.hp.hpl.jena.sparql.expr.ExprEvalException;
import com.hp.hpl.jena.sparql.expr.ExprList;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionBase;
import com.hp.hpl.jena.sparql.util.Utils;

public class log extends FunctionBase {

    @Override
    public NodeValue exec(List<NodeValue> args) {
        if (args.size() < 1 || args.size() > 2)
            throw new ExprEvalException("Invalid number of arguments");

        NodeValue v = args.get(0);

        if (args.size() == 1) {
            // Log base 10
            return NodeValue.makeDouble(Math.log10(v.getDouble()));
        } else {
            // Log with arbitrary base
            // See http://en.wikipedia.org/wiki/List_of_logarithmic_identities#Changing_the_base
            NodeValue base = args.get(1);

            return NodeValue.makeDouble(Math.log10(v.getDouble()) / Math.log10(base.getDouble()));
        }
    }

    @Override
    public void checkBuild(String uri, ExprList args) {
        if (args.size() < 1 || args.size() > 2)
            throw new QueryBuildException("Function '" + Utils.className(this) + "' takes one/two argument(s)");
    }

}
