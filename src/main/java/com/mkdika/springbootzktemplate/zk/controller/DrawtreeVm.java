/*
 * The MIT License
 *
 * Copyright 2018 Maikel Chandika <mkdika@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mkdika.springbootzktemplate.zk.controller;

import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Getter
@Setter
public class DrawtreeVm {

    private final String appInfo = "Draw Tree";

    private String result;

    @Init
    public void init() {

    }

    @Command
    @NotifyChange("result")
    public void process() {

        //START OF SECTION
        //DO NOT MODIFY THIS SECTION
        int index = 0;
        TreeNode[] treeNode = new TreeNode[22];
        treeNode[index++] = new TreeNode(10, 0, "C:\\");
        treeNode[index++] = new TreeNode(20, 10, "Windows");		//Parent: 10=C:\
        treeNode[index++] = new TreeNode(30, 20, "System");			//Parent: 20=Windows
        treeNode[index++] = new TreeNode(40, 30, "One.DLL");		//Parent: 30=System
        treeNode[index++] = new TreeNode(50, 30, "Two.DLL");		//Parent: 30=System
        treeNode[index++] = new TreeNode(60, 30, "Config");			//Parent: 30=System
        treeNode[index++] = new TreeNode(70, 60, "Three.DLL");		//Parent: 60=Config
        treeNode[index++] = new TreeNode(80, 20, "System32");		//Parent: 20=Windows
        treeNode[index++] = new TreeNode(90, 80, "Config32");		//Parent: 80=System32
        treeNode[index++] = new TreeNode(100, 90, "Four.DLL");		//Parent: 90=Config32
        treeNode[index++] = new TreeNode(110, 20, "SysWow64");		//Parent: 20=Windows
        treeNode[index++] = new TreeNode(120, 110, "Config64");		//Parent:110=SysWow64
        treeNode[index++] = new TreeNode(130, 120, "Five.DLL");		//Parent:120=Config64
        treeNode[index++] = new TreeNode(140, 10, "Program");		//Parent: 10=C:\
        treeNode[index++] = new TreeNode(150, 140, "Office");		//Parent:140=Program
        treeNode[index++] = new TreeNode(160, 150, "Excel");		//Parent:150=Office
        treeNode[index++] = new TreeNode(170, 150, "Word");			//Parent:150=Office
        treeNode[index++] = new TreeNode(180, 150, "Visio");		//Parent:150=Office
        treeNode[index++] = new TreeNode(190, 30, "Two-B.DLL");		//Parent: 30=System
        treeNode[index++] = new TreeNode(200, 60, "Three-B.DLL");	//Parent: 60=Config
        treeNode[index++] = new TreeNode(210, 90, "Four-B.DLL");	//Parent: 90=Config32
        treeNode[index++] = new TreeNode(220, 120, "Five-B.DLL");	//Parent:120=Config64
        //END OF SECTION

        /*		Expected Result
		 *		-- C:\
		 *			-- Program
		 *				-- Office
		 *					-- Excel
		 *					-- Visio
		 *					-- Word
		 *			-- Windows
		 *				-- System
		 *					-- Config
		 *						-- Three.DLL
		 *						-- Three-B.DLL
		 *					-- One.DLL
		 *					-- Two.DLL
		 *					-- Two-B.DLL
		 *				-- System32
		 *					-- Config32
		 *						-- Four.DLL
		 *						-- Four-B.DLL
		 *				-- SysWow64
		 *					-- Config64
		 *						-- Five.DLL
		 *						-- Five-B.DLL
         */
        result = printTree(treeNode, 0, "");
        System.out.println(">>>\n" + result);
    }

    private String printTree(TreeNode[] treenode, int level, String prefix) {
        StringBuilder sb = new StringBuilder();
        prefix = prefix + "    ";

        int n = 0;
        for (int i = 0; i < treenode.length; i++) {
            if (treenode[i].parentNodeID == level) {
                n++;
            }
        }

        TreeNode[] child = new TreeNode[n];
        int ni = 0;
        for (int i = 0; i < treenode.length; i++) {
            if (treenode[i].parentNodeID == level) {
                child[ni] = treenode[i];
                ni++;
            }
        }

        //sort
        sortTree(child);

        for (int i = 0; i < child.length; i++) {

            sb.append(prefix).append("-- ").append(child[i].nodeName).append("\n");
            sb.append(printTree(child, child[i].nodeID, prefix));

        }
        return sb.toString();
    }

    private void sortTree(TreeNode[] treenode) {
        for (int i = 0; i < (treenode.length - 1); i++) {
            for (int j = 0; j < (treenode.length - 1); j++) {
                if (treenode[j + 1].nodeName.compareTo(treenode[j].nodeName) < 0) {
                    TreeNode temp = treenode[j];
                    treenode[j] = treenode[j + 1];
                    treenode[j + 1] = temp;

                }
            }
        }

    }

    //START OF SECTION
    //DO NOT MODIFY THIS SECTION
    public static class TreeNode {

        int nodeID;
        int parentNodeID;
        String nodeName;

        public TreeNode(int nodeID, int parentNodeID, String nodeName) {
            this.nodeID = nodeID;
            this.parentNodeID = parentNodeID;
            this.nodeName = nodeName;
        }
    }
    //END OF SECTION

}
