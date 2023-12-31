package com.twitter.demo.users


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
class User {
    @Id
    String id
    def username
    def email
    def password
    Set<String> followingIdSet = []
    Set<String> followerIdSet = []

    User() {
    }

    User(def username, def email, def password) {
        this.username = username
        this.email = email
        this.password = password
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        User user = (User) o

        if (email != user.email) return false
        if (followerIdSet != user.followerIdSet) return false
        if (followingIdSet != user.followingIdSet) return false
        if (id != user.id) return false
        if (password != user.password) return false
        if (username != user.username) return false

        return true
    }

    int hashCode() {
        int result
        result = (id != null ? id.hashCode() : 0)
        result = 31 * result + (username != null ? username.hashCode() : 0)
        result = 31 * result + (email != null ? email.hashCode() : 0)
        result = 31 * result + (password != null ? password.hashCode() : 0)
        result = 31 * result + (followingIdSet != null ? followingIdSet.hashCode() : 0)
        result = 31 * result + (followerIdSet != null ? followerIdSet.hashCode() : 0)
        return result
    }

    @Override
    String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username=" + username +
                ", email=" + email +
                ", password=" + password +
                ", followingIdSet=" + followingIdSet +
                ", followerIdSet=" + followerIdSet +
                '}'
    }
}
