package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Crystal implements Obj{

    private final static float[] VERTICES = {
            // u_left
            1, 0, 0,
            0, -1, 0,
            0, 0, 1,
            // u_right
            -1, 0, 0,
            0, 1, 0,
            0, 0, 1,
            // u_back
            -1, 0, 0,
            0, -1, 0,
            0, 0, 1,
            // u_front
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
            // l_left
            1, 0, 0,
            0, -1, 0,
            0, 0, -1,
            // l_right
            -1, 0, 0,
            0, 1, 0,
            0, 0, -1,
            // l_back
            -1, 0, 0,
            0, -1, 0,
            0, 0, -1,
            // l_front
            1, 0, 0,
            0, 1, 0,
            0, 0, -1

    };

    private final FloatBuffer vbuf;

    Crystal() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // u_left
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // u_right
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // u_back
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // u_front
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // l_left
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // l_right
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // l_back
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // l_front
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);

    }
}
