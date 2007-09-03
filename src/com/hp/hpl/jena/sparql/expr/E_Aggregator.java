/*
 * (c) Copyright 2007 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.sparql.expr;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.sparql.expr.aggregate.Aggregator;
import com.hp.hpl.jena.sparql.function.FunctionEnv;

/** Group aggregation functions calculate a value during grouping and
 *  place it in the output binding.  This class is relationship of 
 *  an aggregation expression and that variable.  Evaluation return
 *  the variable's bound value. 
 */

public class E_Aggregator extends ExprVar
{
    protected Aggregator aggregator ;
    
    public E_Aggregator(String name, Aggregator agg)    { super(name) ; aggregator = agg ; }
    public E_Aggregator(Node n, Aggregator agg)         { super(n) ; aggregator = agg ; }
    public E_Aggregator(Var v, Aggregator agg)          { super(v) ; aggregator = agg ; }
    
    public Aggregator getAggregator()   { return aggregator ; }
    
    public String toExprString()        { return aggregator.toString(); }
}

class A extends ExprNode
{
    protected ExprVar varNode = null ;
    protected Aggregator aggregator ;
    
    public A(String name, Aggregator agg)    { varNode = new ExprVar(name) ; aggregator = agg ; }
    public A(Node n, Aggregator agg)         { varNode = new ExprVar(n) ; aggregator = agg ; }
    public A(Var v, Aggregator agg)          { varNode= new ExprVar(v) ; aggregator = agg ; }
    

    // Fake 
    public boolean isVariable() { return true ; }
    public String getVarName()  { return varNode.getVarName() ; }
    public ExprVar getExprVar() { return varNode ; }
    public Var asVar()          { return varNode.asVar() ; }
    public Node getAsNode()     { return varNode.getAsNode() ; }

    
    public Expr copySubstitute(Binding binding, boolean foldConstants)
    {
        return null ;
    }

    public NodeValue eval(Binding binding, FunctionEnv env)
    {
        return null ;
    }

    public int hashCode()
    {
        return 0 ;
    }

    public boolean equals(Object other)
    {
        return false ;
    }

    public void visit(ExprVisitor visitor)
    {}
    
}

/*
 * (c) Copyright 2007 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */