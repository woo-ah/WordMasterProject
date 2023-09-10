package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }

    public void addWord(){
        Word one = (Word) add();
        list.add(one);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!!\n");
    }

    @Override
    public int update(Object obj) {

        return 0;
    }


    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next(); //공백 허용 안하기 위해 next 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine(); // id 뒤에 있는 엔터가 여기 들어가 짐. 따라서 뜻을 입력 하는 것을 넘어 가지 않고 잘 실행됨
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.print("단어가 수정되었습니다. \n");

    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist =  new ArrayList<>();
        int j=0;
        System.out.println("-------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("-------------------------------");
        return idlist;
    }

    @Override
    public int delete(Object obj) {

        return 0;
    }

    public void deleteItem(){
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next(); //공백 허용 안하기 위해 next 사용
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine(); // id 뒤에 있는 엔터가 여기 들어가 짐. 따라서 뜻을 입력 하는 것을 넘어 가지 않고 잘 실행됨
        System.out.print("=> 정말로 삭제하실래요?(Y/N) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.print("단어가 삭제되었습니다. \n");
        }else{
            System.out.print("취소되었습니다.\n");
        }

    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll(){
        System.out.println("-------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-------------------------------");
    }

}
