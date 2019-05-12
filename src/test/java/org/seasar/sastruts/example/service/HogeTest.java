package org.seasar.sastruts.example.service;

import org.junit.Test;

import static org.easymock.classextension.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.classextension.EasyMock;

/**
 * http://yamap55.hatenablog.com/entry/2015/02/10/000937を参照したもの
 * @author ysaito
 *
 */
public class HogeTest {
	@Test
    public void testMethod() throws Exception {
        Hoge hogeMock = createMock(Hoge.class);

                // 返り値がStringの場合。
        expect(hogeMock.methodA()).andReturn("mockMethodA"); 

                // 返り値がvoidの場合。
        hogeMock.methodB("str"); // 一回処理を呼び出す。
        EasyMock.expectLastCall(); // 一つ前の挙動を記録する。

        replay(hogeMock);

        assertThat(hogeMock.methodA(), is("mockMethodA"));
        hogeMock.methodB("str"); // str以外の値の場合に例外。

        verify(hogeMock);
    }
}
