package com.smpaaark.programmers.coupang;

import java.util.*;

public class Q1_1 {

    public static void main(String[] args) {
        Q1_1 q = new Q1_1();
        System.out.println(q.solution(new String[] {"13123820 BusinessManagement AAA", "15047648 Economics AAA", "17869244 ComputerScience AAA", "19000000 ElectronicEngineering AAA", "14281264 Law AAA", "19000000 ElectronicEngineering BBB", "16188768 BusinessManagement BBB", "14634411 Law BBB", "16628760 Economics BBB", "14863606 BusinessManagement CCC", "13165700 Law CCC", "15215218 ComputerScience CCC"}, 4, 3, 3));
    }

    public int solution(String[] students, int n, int m, int k) {
        // 2개 이상 동아리에 가입한 학생을 체크하기 위한 map
        HashMap<String, Student> map = new HashMap<>();

        for (String str : students) {
            // 데이터 파싱
            String[] splitStudent = str.split(" ");
            String id = splitStudent[0];
            String year = splitStudent[0].substring(0, 2);
            String major = splitStudent[1];
            String club = splitStudent[2];

            if (map.containsKey(id)) { // 이미 가입된 동아리가 있으면 뒤의 계산에서 아예 제외되어야 하므로 null로 값을 바꾼다.
                map.put(id, null);
            } else { // 이미 가입된 동아리가 없으면 map에 추가
                map.put(id, new Student(id, year, major, club));
            }
        }

        Map<String, Club> clubMap = new HashMap<>();
        for (Student student : map.values()) {
            if (student != null) { // 1개의 동아리에 가입한 학생들만 아래 로직 수행
                // 가입한 동아리의 이름을 가져온다.
                String clubName = student.club;
                Club club = null;

                // 이미 생성된 동아리이면 clubMap에서 가져오고 아닐 경우 새로 만든 후 clubMap에 저장한다.
                if (clubMap.containsKey(student.club)) {
                    club = clubMap.get(student.club);
                } else {
                    club = new Club(clubName);
                    clubMap.put(clubName, club);
                }

                // 연도 set에 넣는다. 이미 들어가 있는 경우엔 생략
                if (!club.year.contains(student.year)) {
                    club.year.add(student.year);
                }

                // 학과 set에 넣는다. 이미 들어가 있는 경우엔 생략
                if (!club.major.contains(student.major)) {
                    club.major.add(student.major);
                }

                // 가입된 학생 수를 1 증가시킨다.
                club.studentCount++;
            }
        }

        // 현재 생성되어 있는 동아리의 갯수를 먼저 저장한다.
        int result = clubMap.size();
        for (Club club : clubMap.values()) {
            // n, m, k 조건에 맞지 않은 동아리면 결과에서 1을 뺀다.
            if (club.studentCount < n || club.year.size() < m || club.major.size() < k) {
                result--;
            }
        }

        // 남은 동아리 갯수 리턴
        return result;
    }

    class Student {

        String id;
        String year;
        String major;
        String club;

        public Student(String id, String year, String major, String club) {
            this.id = id;
            this.year = year;
            this.major = major;
            this.club = club;
        }

    }

    class Club {

        String name;
        Set<String> year = new HashSet<>();
        Set<String> major = new HashSet<>();
        int studentCount;

        public Club(String name) {
            this.name = name;
        }

    }

}
