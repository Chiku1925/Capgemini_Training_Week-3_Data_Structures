class FriendNode {
    int userId;
    String name;
    int age;
    FriendNode next;

    FriendNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.friends = null;
        this.next = null;
    }
}

class SocialMediaConnections {
    UserNode head;

    void addUser(int userId, String name) {
        UserNode node = new UserNode(userId, name);
        if (head == null) {
            head = node;
        } else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    void addFriend(int userId, int friendId, String friendName, int friendAge) {
        UserNode user = findUser(userId);
        if (user != null) {
            FriendNode friend = new FriendNode(friendId, friendName, friendAge);
            friend.next = user.friends;
            user.friends = friend;
        }
    }

    void removeFriend(int userId, int friendId) {
        UserNode user = findUser(userId);
        if (user != null) {
            FriendNode temp = user.friends, prev = null;
            while (temp != null) {
                if (temp.userId == friendId) {
                    if (prev != null) prev.next = temp.next;
                    if (temp == user.friends) user.friends = temp.next;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }
    }

    UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            FriendNode temp = user.friends;
            while (temp != null) {
                System.out.println(temp.name);
                temp = temp.next;
            }
        }
    }

    void countFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            int count = 0;
            FriendNode temp = user.friends;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            System.out.println("Total friends: " + count);
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections sm = new SocialMediaConnections();
        sm.addUser(1, "Alice");
        sm.addUser(2, "Bob");
        sm.addFriend(1, 2, "Bob", 25);
        sm.displayFriends(1);
        sm.countFriends(1);
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}
