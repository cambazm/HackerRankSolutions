using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution {

    class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void InsertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    static void PrintDoublyLinkedList(DoublyLinkedListNode node, string sep, TextWriter textWriter) {
        while (node != null) {
            textWriter.Write(node.data);

            node = node.next;

            if (node != null) {
                textWriter.Write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current = head;
        List<int> values = new List<int>();
        List<DoublyLinkedListNode> newValues = new List<DoublyLinkedListNode>();
        values.Add(data);
        while(current.next!=null) {
            values.Add(current.data);
            current = current.next;
        }
        values.Add(current.data);
        int[] sorted = values.ToArray();
        Array.Sort(sorted);
        for(int i=0; i<sorted.Length; i++) {
            
            DoublyLinkedListNode newItem = new DoublyLinkedListNode(sorted[i]);
            newValues.Add(newItem);
        }
        for(int i=0; i<sorted.Length; i++) {
            if(i==0)
                newValues[i].prev = null;
            else {
                newValues[i].prev = newValues[i-1];
            }
            if(i==sorted.Length-1)
                newValues[i].next = null;
            else {
                newValues[i].next = newValues[i+1];
            }
        }
        
        return newValues[0];
    }

    static void Main(string[] args) {