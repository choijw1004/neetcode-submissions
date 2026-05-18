class Node {
    char c;
    int cnt;

    public Node(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);
        if (a != 0) {
            pq.offer(new Node('a', a));
        }
        if (b != 0) {
            pq.offer(new Node('b', b));
        }
        if (c != 0) {
            pq.offer(new Node('c', c));
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Node first = pq.poll();
            int currLen = sb.length();
            // 쓸 수 없는 경우
            if (currLen >= 2 && sb.charAt(currLen - 1) == first.c && sb.charAt(currLen - 2) == first.c) {
                if (pq.isEmpty()) break;

                Node second = pq.poll();
                sb.append(second.c);
                second.cnt -= 1;
                if (second.cnt > 0) pq.offer(second);
                pq.offer(first);
            }
            // 쓸 수 있는 경우
            else {
                sb.append(first.c);
                first.cnt -= 1;
                if (first.cnt > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
}