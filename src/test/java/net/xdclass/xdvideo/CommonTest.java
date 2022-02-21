package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.jupiter.api.Test;

/**
 * @author jinxm
 * @date 2022-02-18
 * @description
 */
public class CommonTest {

    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(999);
        user.setName("www.xdclass.net");
        user.setHeadImg("xd");

        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);

    }

    @Test
    public void testCheck() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6Ind3dy54ZGNsYXNzLm5ldCIsImltZyI6InhkIiwiaWF0IjoxNjQ1MTgwNDY3LCJleHAiOjE2NDU3ODUyNjd9.ytvtRgIHOWO6FQt6lOLl2JkB__58PtnfOf5dX-gjiQg";
        Claims claims = JwtUtils.checkJWT(token);
        if(claims != null) {
            String name = (String)claims.get("name");
            String img = (String)claims.get("img");
            int id = (Integer)claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        }else {
            System.out.println("非法token");
        }


    }
}
