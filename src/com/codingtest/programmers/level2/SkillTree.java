package com.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Summer/Winter Coding(~2018) > 스킬트리
public class SkillTree {

    public List<Map<String, String>> makePriorSkillMap(String skill) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> preSkill = new HashMap<>();     //특정 스킬의 선행스킬을 담는다.
        Map<String, String> postSKill = new HashMap<>();       //특정 스킬의 후위스킬을 담는다.

        char[] skillChars = skill.toCharArray();

        for (int i = 1; i < skillChars.length; i++) {
            preSkill.put(String.valueOf(skillChars[i]), String.valueOf(skillChars[i - 1]));
            postSKill.put(String.valueOf(skillChars[i - 1]), String.valueOf(skillChars[i]));
        }

        list.add(preSkill);
        list.add(postSKill);

        return list;
    }

    //스킬트리가 가능한지 확인
    public boolean isPossibleSkillTree(Map<String, String> preSkillMap, Map<String, String> postSKillMap, String skillTree) {
        Map<String, String> preSkill = new HashMap<>(preSkillMap);     //선행 스킬
        Map<String, String> postSkill = new HashMap<>(postSKillMap);   //후위 스킬

        for (char c : skillTree.toCharArray()) {
            String skill = String.valueOf(c);

            //선행 스킬이 있으면
            if (!preSkill.getOrDefault(skill, "0").equals("0"))
                return false;

            else {
                //해당 스킬의 다음 스킬을 찾는다
                String next = postSkill.getOrDefault(skill, "0");
                if (!next.equals("0"))   //해당 스킬의 다음 스킬이 있으면
                    preSkill.put(next, "0");

            }
        }

        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String, String> preSkillMap = makePriorSkillMap(skill).get(0);   //선행 스킬
        Map<String, String> postSKillMap = makePriorSkillMap(skill).get(1);   //후위 스킬

        for (int i = 0; i < skill_trees.length; i++) {
            if (isPossibleSkillTree(preSkillMap, postSKillMap, skill_trees[i]))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        SkillTree st = new SkillTree();
        int solution = st.solution(skill, skillTrees);

        System.out.println("solution = " + solution);

    }
}
