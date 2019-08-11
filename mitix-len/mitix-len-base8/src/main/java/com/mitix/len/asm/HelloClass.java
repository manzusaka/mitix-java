/*
 * Copyright (c) 2010
 *
 * @date 2016
 *
 * @author oldflame-Jm
 *
 * Apache License Version 2.0 http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.mitix.len.asm;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;

/**
 * @author oldflame-Jm TODO
 * @version 1.0.0
 */
public class HelloClass {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "sample/HelloGen", null, "java/lang/Object", null);

        // default constructor
        {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0); // load the first local variable: this
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // main method
        {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); // put
            // System.out
            // to
            // operand
            // stack
            mv.visitLdcInsn("Hello"); // load const "Hello" from const_pool, and put onto the operand
            // stack
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        // save bytecode into disk
        FileOutputStream out = new FileOutputStream("D:/HelloGen.class");
        out.write(cw.toByteArray());
        out.close();
    }

}
