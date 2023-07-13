package ru.yandex.practicum.catsgram.model;

import java.time.LocalDate;

public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}






/*    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // можно оформить и так
        Book otherBook = (Book) obj;
        return Objects.equals(title, otherBook.title) &&
                Objects.equals(author, otherBook.author) &&
                (pagesNumber == otherBook.pagesNumber);
    }

     @Override
    public int hashCode() {
        int hash = 17;
        if (firstName != null) {
            // вычисляем хеш первого поля и добавляем к нему начальное значение
            hash = hash + firstName.hashCode();
        }
        hash = hash * 31; // умножаем промежуточный результат на простое число

        if (lastName != null) {
            // вычисляем хеш второго поля и добавляем его к общему результату
            hash = hash + lastName.hashCode();
        }
        return hash; // возвращаем итоговый хеш
    }

    */