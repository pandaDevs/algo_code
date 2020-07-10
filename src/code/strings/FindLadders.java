package code.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(null == wordList || null == endWord || wordList.size() == 0 || !wordList.contains(endWord)) {
            return new ArrayList<>(2);
        }
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Node> q = new LinkedList<>();
        Node first = new Node(beginWord);
        first.path.add(beginWord);
        q.offer(first);
        while(!q.isEmpty()) {
            int queueSize = q.size();
            for(int i = 0; i < queueSize; ++i) {
                Node currentNode = q.poll();
                for(String nextWord : wordSet) {
                    if(oneWordDiff(currentNode.word, nextWord)) {
                        Node nextNode = new Node(nextWord);
                        nextNode.path = new ArrayList<>(currentNode.path);
                        nextNode.path.add(nextWord);

                        if(nextWord.endsWith(endWord)) {
                            result.add(nextNode.path);
                        } else {
                            q.offer(nextNode);
                        }
                    }
                }

                wordSet.remove(currentNode.word);
            }
            if (!result.isEmpty()) {
                return result;
            }
        }

        return result;
    }

    private boolean oneWordDiff(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        int count = 0;
        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    private class Node{
        String word;
        List<String> path;

        public Node(String word) {
            this.word = word;
            path = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        FindLadders find = new FindLadders();
        String beginWord = "hit";
        String endWord = "cog";
        String[] stringList = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(stringList);
        List<List<String>> result = find.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
