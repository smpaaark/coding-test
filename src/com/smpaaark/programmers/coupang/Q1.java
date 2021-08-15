package com.smpaaark.programmers.coupang;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Q1 q = new Q1();
        System.out.println(q.solution(new String[] {"13123820 BusinessManagement AAA", "15047648 Economics AAA", "17869244 ComputerScience AAA", "19000000 ElectronicEngineering AAA", "14281264 Law AAA", "19000000 ElectronicEngineering BBB", "16188768 BusinessManagement BBB", "14634411 Law BBB", "16628760 Economics BBB", "14863606 BusinessManagement CCC", "13165700 Law CCC", "15215218 ComputerScience CCC"}, 30, 8, 8));
    }

    // 최소 인원수 n, 최소 입학 연도 수 m, 최소 학과 수 k
    public int solution(String[] students, int n, int m, int k) {

        // 동아리와 학생 Map 생성
        HashMap<String, Club> clubMap = new HashMap<>();
        HashMap<String, Student> studentMap = new HashMap<>();

        for (String str : students) {
            // 데이터 파싱
            String[] splitStudent = str.split(" ");
            String id = splitStudent[0];
            String year = splitStudent[0].substring(0, 2);
            String major = splitStudent[1];

            Student student = null;

            // 이미 다른 동아리에 가입된 학생일 경우
            if (studentMap.containsKey(id)) {
                student = studentMap.get(id);

                // 현재 가입된 동아리 객체 가져온다.
                Club club = student.club;
                if (club != null) {
                    // 동아리에 해당 학생의 정보를 모두 제외시킵니다.

                    // 연도
                    int minusYear = club.yearMap.get(year) - 1;
                    if (minusYear == 0) {
                        club.yearMap.remove(year);
                    } else {
                        club.yearMap.put(year, minusYear);
                    }

                    // 학과
                    int minusMajor = club.majorMap.get(major) - 1;
                    if (minusMajor == 0) {
                        club.majorMap.remove(major);
                    } else {
                        club.majorMap.put(year, minusMajor);
                    }
                    club.students.remove(student);
                    student.club = null;
                }
            } else { // 학생 정보가 map에 없을 경우 새 학생이다.
                student = new Student(id, year, major);

                // 동아리 객체 생성
                String clubName = splitStudent[2];

                Club club = null;
                if (clubMap.containsKey(clubName)) { // 동아리가 이미 존재하면 해당 동아리 객체 가져온다.
                    club = clubMap.get(clubName);
                } else { // 동아리가 새로운 동아리면 동아리 객체를 생성한다.
                    club = new Club(clubName);
                    clubMap.put(clubName, club);
                }

                // 동아리 객체에 학생 정보 입력
                club.yearMap.put(year, club.yearMap.getOrDefault(year, 0) + 1);
                club.majorMap.put(major, club.majorMap.getOrDefault(major, 0) + 1);
                club.students.add(student);

                // 학생 객체에 동아리 추가
                student.club = club;

                // 학생 map에 학생 객체 추가
                studentMap.put(id, student);
            }
        }

        int result = clubMap.size();
        for (String clubName : clubMap.keySet()) {
            Club club = clubMap.get(clubName);
            if (club.students.size() < n || club.yearMap.size() < m || club.majorMap.size() < k) {
                result--;
            }
        }

        return result;
    }

    class Student {

        String id;
        String year;
        String major;
        Club club;

        public Student(String id, String year, String major) {
            this.id = id;
            this.year = year;
            this.major = major;
        }

    }

    class Club {

        String name;
        Map<String, Integer> yearMap = new HashMap<>();
        Map<String, Integer> majorMap = new HashMap<>();
        Set<Student> students = new HashSet<>();

        public Club(String name) {
            this.name = name;
        }

    }

}
