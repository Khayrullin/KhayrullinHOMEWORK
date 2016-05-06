package ru.kpfu.itis.group11506.semestr;

class LongArithmetic {

    String addition(String a1, String b1) {
        String number;
        byte[] a, b;
        boolean isANegative = false, isBNegative = false;
        a = new byte[a1.length() + b1.length()];
        for (int i = a1.length() - 1; i > -1; i--) {
            int j = a1.length() - i - 1;
            a[i] = (byte) Character.getNumericValue(a1.charAt(j));
        }
        b = new byte[b1.length() + a1.length()];
        for (int i = b1.length() - 1; i > -1; i--) {
            int j = b1.length() - i - 1;
            b[i] = (byte) Character.getNumericValue(b1.charAt(j));
        }
        for (int i = a.length - 1; i > -1; i--) {
            if (a[i] == -1) {
                isANegative = true;
                a[i] = 0;
            }
        }
        for (int i = b.length - 1; i > -1; i--) {
            if (b[i] == -1) {
                isBNegative = true;
                b[i] = 0;
            }
        }
        if (isANegative && !isBNegative) {
            a1 = a1.replace("-", "");
            number = subtraction(b1, a1);
        } else if (!isANegative && isBNegative) {
            b1 = b1.replace("-", "");
            number = subtraction(a1, b1);
        } else {
            if (isANegative) {
                number = stringReturner(true, add(a, b));
            } else {
                number = stringReturner(false, add(a, b));
            }
        }
        return number;
    }

    private byte[] add(byte[] a, byte[] b) {
        byte[] bb = new byte[a.length + b.length];
        System.arraycopy(b, 0, bb, 0, b.length);
        byte j1 = 0;
        byte[] c = new byte[a.length + bb.length];
        System.arraycopy(a, 0, c, 0, a.length);
        for (int i = 0; i < bb.length; i++) {
            byte j = (byte) (c[i] + bb[i]);
            c[i] = (byte) ((j1 + j) % 10);
            j1 = (byte) ((j + j1) / 10);
        }
        String t = stringReturner(false, c);
        c = new byte[t.length()];
        for (int i = t.length() - 1; i > -1; i--) {
            int j11 = t.length() - i - 1;
            c[i] = (byte) Character.getNumericValue(t.charAt(j11));
        }
        return c;
    }

    String subtraction(String a1, String b1) {
        String number;
        byte[] a, b;
        boolean isANegative = false, isBNegative = false;
        a = new byte[a1.length()];
        for (int i = a1.length() - 1; i > -1; i--) {
            int j = a1.length() - i - 1;
            a[i] = (byte) Character.getNumericValue(a1.charAt(j));
        }
        b = new byte[b1.length()];
        for (int i = b1.length() - 1; i > -1; i--) {
            int j = b1.length() - i - 1;
            b[i] = (byte) Character.getNumericValue(b1.charAt(j));
        }
        for (int i = a.length - 1; i > -1; i--) {
            if (a[i] == -1) {
                isANegative = true;
                a[i] = 0;
            }
        }
        for (int i = b.length - 1; i > -1; i--) {
            if (b[i] == -1) {
                isBNegative = true;
                b[i] = 0;
            }
        }
        if (isANegative && !isBNegative) {
            number = stringReturner(true, add(a, b));
        } else if (!isANegative && isBNegative) {
            number = stringReturner(false, add(a, b));
        } else {
            if (isANegative) {
                byte[] helper = a;
                a = b;
                b = helper;
            }
            if (compare(a, b) == 1 || compare(a, b) == 0) {
                number = stringReturner(false, deduct(a, b));
            } else {
                number = stringReturner(true, deduct(b, a));
            }
        }
        return number;
    }

    private byte[] deduct(byte[] a, byte[] b) {
        byte[] bb = new byte[a.length + b.length];
        System.arraycopy(b, 0, bb, 0, b.length);
        int helper = 0;
        byte[] c = new byte[a.length + bb.length];
        System.arraycopy(a, 0, c, 0, a.length);
        for (int i = 0; i < bb.length; i++) {
            byte j = (byte) (c[i] - bb[i]);
            if (j < 0) {
                if (c[i + 1] == 0) {
                    while (c[i + 1 + helper] == 0) {
                        c[i + 1 + helper] = 9;
                        helper += 1;
                    }
                    c[i + 1 + helper] -= 1;
                    helper = 0;
                } else {
                    c[i + 1] -= 1;
                }
                c[i] = (byte) (10 + j);
            } else {
                c[i] = j;
            }
        }
        String t = stringReturner(false, c);
        c = new byte[t.length()];
        for (int i = t.length() - 1; i > -1; i--) {
            int j11 = t.length() - i - 1;
            c[i] = (byte) Character.getNumericValue(t.charAt(j11));
        }
        return c;
    }


    private String stringReturner(boolean needNegative, byte[] c) {
        int index = 0;
        String a;
        if (needNegative) {
            a = "-";
        } else {
            a = "";
        }
        for (int i = c.length - 1; i > -1; i--) {
            if (c[i] != 0) {
                index = i;
                break;
            }
        }
        for (int i = index; i > -1; i--) {
            a = a + c[i];
        }
        return a;
    }

    private int compare(byte[] a, byte[] b) {
        if (a.length > b.length) {
            return 1;
        } else if (a.length < b.length) {
            return -1;
        } else {
            for (int i = a.length - 1; i > -1; i--) {
                if (a[i] > b[i]) {
                    return 1;
                } else if (a[i] < b[i]) {
                    return -1;
                }
            }
            return 0;
        }
    }

    String multiplication(String a1, String b1) {
        String number;
        byte[] a, b;
        boolean isANegative = false, isBNegative = false;
        a = new byte[a1.length()];
        for (int i = a1.length() - 1; i > -1; i--) {
            int j = a1.length() - i - 1;
            a[i] = (byte) Character.getNumericValue(a1.charAt(j));
        }
        b = new byte[b1.length()];
        for (int i = b1.length() - 1; i > -1; i--) {
            int j = b1.length() - i - 1;
            b[i] = (byte) Character.getNumericValue(b1.charAt(j));
        }
        for (int i = a.length - 1; i > -1; i--) {
            if (a[i] == -1) {
                isANegative = true;
                a[i] = 0;
            }
        }
        for (int i = b.length - 1; i > -1; i--) {
            if (b[i] == -1) {
                isBNegative = true;
                b[i] = 0;
            }
        }
        if ((isANegative && isBNegative) || (!isANegative) && (!isBNegative)) {
            number = stringReturner(false, multiply(a, b));
        } else {
            number = stringReturner(true, multiply(a, b));
        }


        return number;
    }


    private byte[] multiply(byte[] a, byte[] b) {
        long a0, b0;
        byte[] a0b0, a1b1, a0a1b0b1, x, y, a1, b1, a00, b00;
        String j, j2;
        if (a.length > 8) {
            a0 = Long.parseLong(stringReturner(false, a).substring(
                    stringReturner(false, a).length() - 8, stringReturner(false, a).length()));
            a1 = new byte[a.length - 8];
            System.arraycopy(a, 8, a1, 0, a.length - 8);
            j = stringReturner(false, a).substring(
                    stringReturner(false, a).length() - 8, stringReturner(false, a).length());
            a00 = new byte[j.length()];
            for (int i = j.length() - 1; i > -1; i--) {
                int m = j.length() - i - 1;
                a00[i] = (byte) Character.getNumericValue(j.charAt(m));
            }
        } else {
            a0 = byteArraytoLong(a);
            a1 = new byte[]{0};
            a00 = longToByteArray(a0);
        }
        if (b.length > 8) {
            b0 = Long.parseLong(stringReturner(false, b).substring(
                    stringReturner(false, b).length() - 8, stringReturner(false, b).length()));
            b1 = new byte[b.length - 8];
            System.arraycopy(b, 8, b1, 0, b.length - 8);
            j2 = stringReturner(false, b).substring(
                    stringReturner(false, b).length() - 8, stringReturner(false, b).length());
            b00 = new byte[j2.length()];
            for (int i = j2.length() - 1; i > -1; i--) {
                int m = j2.length() - i - 1;
                b00[i] = (byte) Character.getNumericValue(j2.charAt(m));
            }
        } else {
            b0 = byteArraytoLong(b);
            b1 = new byte[]{0};
            b00 = longToByteArray(b0);
        }
        a0b0 = longToByteArray(a0 * b0);
        if (add(a00, a1).length > 8 || add(b00, b1).length > 8) {
            a0a1b0b1 = multiply(add(a00, a1), add(b00, b1));
        } else {
            a0a1b0b1 = longToByteArray(byteArraytoLong(add(a00, a1)) * byteArraytoLong(add(b00, b1)));
        }
        if (a1.length > 8 || b1.length > 8) {
            a1b1 = multiply(a1, b1);
        } else {
            a1b1 = longToByteArray(byteArraytoLong(a1) * byteArraytoLong(b1));
        }
        x = getZeros(8, deduct((deduct(a0a1b0b1, a0b0)), a1b1));
        y = getZeros(16, a1b1);

        return add(add(a0b0, x), y);
    }


    private byte[] longToByteArray(long l) {
        byte[] a;
        String string = Long.toString(l);
        a = new byte[string.length()];
        for (int i = string.length() - 1; i > -1; i--) {
            int j = string.length() - i - 1;
            a[i] = (byte) Character.getNumericValue(string.charAt(j));
        }
        return a;
    }

    private long byteArraytoLong(byte[] array) {
        return Long.parseLong(stringReturner(false, array));

    }


    private byte[] getZeros(int zeroLength, byte[] b) {
        byte[] c = new byte[b.length + zeroLength];
        System.arraycopy(b, 0, c, zeroLength, b.length);
        return c;
    }

    String degree(int n, String number) {
        String s = number;
        while (n > 1) {
            s = multiplication(s, number);
            n -= 1;
        }
        return s;
    }

    String leftLogicalShift(int n, String number) {
        long l = (long) Math.pow(2d, (double) n);
        return multiplication(stringReturner(false, longToByteArray(l)), number);
    }


    byte[] convertToArray(String one) { //преобразует string в байтовый массив
        byte[] a = new byte[one.length()];
        for (int i = 0; i < one.length(); i++) {
            a[i] = Byte.valueOf(String.valueOf(one.charAt(i)));
        }
        return a;
    }

    byte[] division(byte[] one, byte[] two) { //деление
        if (one.length >= two.length && isBigger(one, two)) { //если 1 число больше 2
            byte[] result = new byte[one.length - two.length + 1]; //вводим байтовый массив-результат
            for (int i = 0; one.length - i >= two.length; i++) {//отделяем СЛЕВА от делимого количество символов как в делителе
                int k = i - 1;
                int plus = 0;
                int may = 0;
                while (k != -1) { //проверка - сколько ненулевых разрядов осталось после предыдущего вычитания
                    if (one[k] != 0) {
                        plus++;
                        plus += may;
                        may = 0;
                    } else {
                        may++;
                    }
                    k--;
                }
                byte[] a1 = subArray(one, i - plus, two.length + plus); //подмассив
                if (isBigger(a1, two)) { //если подмассив > числа на которе делю то заходим в 1.1
                    byte count = 2; //1.1
                    byte[] mult = multiply(two, count);
                    while (!isBigger(mult, a1) || isEqual(mult, a1)) {
                        count++;//множитель для делителя чтобы вычитаемое было с мин. остатком
                        mult = multiply(two, count);
                    }
                    count--;
                    if ((i + 1) == result.length) { // добавляет разряд в ответ
                        System.arraycopy(result, 1, result, 0, result.length - 1);
                        result[result.length - 1] = count;
                    } else
                        result[i + 1] = count;
                    a1 = subtraction(a1, multiply(two, count)); // вычитание
                    for (k = i; k < a1.length + i; k++) { // заменяем на следующий делитель
                        one[k - plus] = a1[k - i];
                    }
                } else { // если не хватило одного добавленного разряда записываем в ответе 0 и спускаем еще один разряд
                    if ((i + 1) == result.length) {
                        System.arraycopy(result, 1, result, 0, result.length - 1);
                        result[result.length - 1] = 0;
                    } else
                        result[i + 1] = 0;
                }
            }
            return result;
        } else {
            return new byte[1]; //если делитель больше делимого ответ - 0
        }

    }

    private byte[] subArray(byte[] bigOne, int startIndex, int size) { // принимаем на вход массив и делим его на подмассиввы длинны делителя или делителя+1
        int c = startIndex;
        while (size > 0 && bigOne[c] == 0) {
            size--;
            startIndex++;
            c++;
        }
        if (size != 0) {
            byte[] result = new byte[size]; // записвываем оставшиеся ненелевые разряды
            System.arraycopy(bigOne, startIndex, result, 0, size);
            return result;
        } else
            return new byte[1];

    }


    private byte[] subtraction(byte[] one, byte[] two) {
        if (one.length <= two.length) {
            if (one.length < two.length)
                if (two[0] == 0) {
                    two = subArray(two, 1, two.length - 1);
                }
            for (int i = one.length - 1; i > -1; i--) {
                if (one[i] < two[i]) {
                    int k = i - 1;
                    while (one[k] == 0)
                        k--;
                    one[k]--;
                    k++;
                    while (k != i) {
                        one[k] += 9;
                        k++;
                    }
                    one[i] = (byte) (one[i] + 10 - two[i]);
                } else {
                    one[i] = (byte) (one[i] - two[i]);
                }
            }
        } else {
            for (int i = two.length; i > 0; i--) {
                if (one[i] < two[i - 1]) {
                    int k = i - 1;
                    while (one[k] == 0)
                        k--;
                    one[k]--;
                    k++;
                    while (k != i) {
                        one[k] += 9;
                        k++;
                    }
                    one[i] = (byte) (one[i] + 10 - two[i - 1]);
                } else {
                    one[i] = (byte) (one[i] - two[i - 1]);
                }
            }
        }
        return one;
    }


    private byte[] multiply(byte[] first, byte second) { //умножение на число
        byte[] result = new byte[first.length + 1];
        int remember = 0;// запоминает доп разряды для умножения
        for (int i = first.length; i > 0; i--) {
            result[i] = (byte) (first[i - 1] * second + remember);
            remember = 0;
            if (result[i] > 9) {
                remember = result[i] / 10;
                result[i] = (byte) (result[i] % 10);
            }
        }
        if (remember != 0)
            result[0] = (byte) remember;
        return result;
    }

    private boolean isEqual(byte[] one, byte[] two) {//равны числа или нет(делитель и делимое)
        int i = 0;
        int k = 0;
        while (one[i] == 0) {//пропуск нулей в начале
            i++;
        }
        while (two[k] == 0) {
            k++;
        }
        if ((one.length - i) == (two.length - k)) {
            boolean flag = true;
            while (i < one.length && flag) {
                flag = (one[i] == two[k]);
                i++;
                k++;
            }
            return flag;
        } else
            return false;
    }

    private boolean isBigger(byte[] one, byte[] two) {
        int i = 0;
        if (one.length == two.length) {
            while (i < one.length && one[i] == two[i]) {
                i++;
            }
            return !(i < two.length && one[i] < two[i]);
        } else {
            if (one.length > two.length) {
                int dif = one.length - two.length;

                if (dif == 1 && one[0] != 0) {
                    return true;
                } else {
                    if (dif == 1) {
                        while (one[i + 1] == two[i] && (i + 2) < one.length) {
                            i++;
                        }
                        return !(i < two.length && one[i + 1] < two[i]);
                    } else {
                        for (int l = 0; l < dif; l++) {
                            if (one[l] != 0)
                                return true;
                        }

                        while (one[i + dif] == two[i] && (i + dif) < one.length) {
                            i++;
                        }
                        return !(i < two.length && one[i + dif] < two[i]);
                    }
                }
            } else {
                return false;
            }
        }
    }

    void showArray(byte[] array) {
        for (byte anArray : array) System.out.print(anArray);
    }

     void rightLogicalShift(int n, String number) {
        byte[] b = convertToArray(degree(n,"2"));
         showArray(division(convertToArray(number),b));
    }

}


