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

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Getter
@Setter
public class FactorialRecursiveVm {

    private final String appInfo = "Factorial Recursive";

    private int n;
    private String result;

    @Init
    public void init() {

    }

    @Command
    @NotifyChange("result")
    public void submit() {

        if (n < 0) {
            result = "N harus diatas samadengan nol.";
        } else if (n == 0) {
            result = "Faktorial dari 0 adalah 0";
        } else {
           

            result = "Faktorial dari " + n + " adalah " + frec(n);
        }

    }
    
    private int frec(int n) {
        if (n == 1) {
            return n;
        }else {            
            return n*frec(--n);
        }
    }

}
