package com.yzj.uuid;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-20 10:27
 */
public class UUIDTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int len = 1000;
        for (int i = 0; i < len; i++) {
            String str = UUID.randomUUID().toString();
            set.add(str);
        }
        System.out.println(set.size() == len);

//        .= .- := =:=
//        == != === !== =/=
//        <-< <<- <-- <- <-> -> --> ->> >->
//        <=< <<= <== <=> => ==> =>> >=>
//        <||| <|| <| <|> |> ||> |||>
//        ~@ ~= ~~ www #[ ]#
    }
}
