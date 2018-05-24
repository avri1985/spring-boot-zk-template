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

import java.util.Arrays;
import java.util.Random;
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
public class SortVm {

    private final String appInfo = "Max Value";

    private Integer no;
    private String result;
    private String result1;    

    @Init
    public void init() {

    }

    @Command
    @NotifyChange({"result","result1"})
    public void process() {

        if (no < 0) {
            result = "tidak boleh dibawah nol!";
        } else {
            int[] x = new int[no];
            Random r = new Random();
            for (int i = 0; i < no; i++) {
                x[i] = r.nextInt(101);
            }

            result = "unsorted: " + Arrays.toString(x).replace("[", "{").replace("]", "}");
            
            for (int i=0;i<(x.length-1);i++) {
                for (int j=0;j<(x.length-1);j++) {
                    if (x[j+1] < x[j]) {
                        x[j] = x[j]+ x[j+1];
                        x[j+1] = x[j] - x[j+1];
                        x[j] = x[j] - x[j+1];
                    }
                }
            }
            
            result1 = "sorted: "+ Arrays.toString(x).replace("[", "{").replace("]", "}");
            
            
            
            
        }
    }

}
