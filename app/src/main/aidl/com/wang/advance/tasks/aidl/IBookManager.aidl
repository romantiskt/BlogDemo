
// IBookManager.aidl
package com.wang.advance.tasks.aidl;

import com.wang.advance.tasks.aidl.Book;

// Declare any non-default types here with import statements

interface IBookManager {
   Book getBook();
   void addBookOut(out Book book);
}
