/*
 * Copyright (C) 2018 Oluwole Oyetoke <oluwoleoyetoke@gmail.com>
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Stacks_And_Queues;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Sort Stack:</b> Write a program to sort a stack such that the smallest
 * items are on the top. You can use an additional temporary stack, but you may
 * not copy the elements into any other data structure (such as an array). The
 * stack supports the following operations: push, pop, peek, and is Empty.
 *
 * @author Oluwole Oyetoke {@literal <}oluwoleoyetoke {@literal @}
 */
public class Question_5 {

    /**
     * Sort stack using two other temporary stacks
     *
     * @param toSort stack to sort
     * @param storage storage for sorted stack
     */
    public void sort(Stack toSort, Stack storage) {
        if (toSort.size() == 0) {
            System.out.println("RECURSIVE SORT (2 EXTRA STACKS): " + Arrays.toString(storage.toArray()));
            return;
        }

        int maximum = 0;
        int poped = 0;
        int stackToSortSize = toSort.size();
        Stack tempStack = new Stack();

        //get maximumvalue in stack
        for (int i = 0; i < stackToSortSize; i++) {
            poped = (int) toSort.pop();
            if (i == 0) {
                maximum = poped;
            }
            if (poped >= maximum) {
                maximum = poped;
            }
            tempStack.push(poped);
        }

        //remove all maximum values from current stack and place in sorted stack
        Stack cutDownStack = new Stack();
        for (int i = 0; i < stackToSortSize; i++) {
            poped = (int) tempStack.pop();
            if (poped == maximum) {
                storage.push(maximum);
            } else {
                cutDownStack.push(poped);
            }
        }
        sort(cutDownStack, storage);
    }

    /**
     * Sort stack using just one other stack
     *
     * @param toSort stack to sort;
     */
    public void sort2(Stack toSort) {
        Stack tempStack = new Stack();
        int toSortSize = toSort.size();
        int poped = 0;
        int tempStackSize = 0;
        int tempPopCount = 0;
        while (toSortSize > 0) {
            poped = (int) toSort.pop();
            tempPopCount = tempStack.size();
            if (tempStackSize == 0) {
                tempStack.add(poped);
            } else {
                tempPopCount = 0;
                for (int i = 0; i < tempStackSize; i++) {
                    
                    if ((int) tempStack.peek() > poped) {
                        tempStack.add(poped);
                        if (tempPopCount > 0) {
                            for (int j = 0; j < tempPopCount; j++) {
                                tempStack.push(toSort.pop());
                            }
                        }
                    } else {
                        toSort.push((int) tempStack.pop());
                        tempPopCount++;
                    }
                }
            }
                toSortSize  = toSort.size();
        }
        System.out.println("ONLY 1 TEMP STACK: " + Arrays.toString(tempStack.toArray()));
    }
    
    /**
     * Main method for stacks and queues question 5.....uncoment to run
     * @param args command line arguments
     *//*
    public static void main(String[] args) {
        Question_5 q = new Question_5();
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        for (int i = 0; i < 20; i++) {
            stack.add(i);
            stack2.add(i);
        }
        System.out.println("Stack Before Sort: " + Arrays.toString(stack.toArray()));
        Stack storage = new Stack();
        q.sort(stack, storage);
        q.sort2(stack2);
    }*/
}
