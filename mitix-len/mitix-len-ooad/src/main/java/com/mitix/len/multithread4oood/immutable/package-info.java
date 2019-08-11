/**
 * @author oldflame-jm
 * @create 2018/4/6
 * ${DESCRIPTION}
 */
package com.mitix.len.multithread4oood.immutable;
//介绍不变模式  想破坏也破坏不了
//讲的是把﻿SharedResource 当资源为不可变时  并发也就没有必要了
// 主要是final的使用和  setter方法不能出现