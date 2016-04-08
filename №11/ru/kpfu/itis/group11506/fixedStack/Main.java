package ru.kpfu.itis.group11506.fixedStack;

public class Main {
    public static void main(String[] args) {
        FixedSizeStack fixedSizeStack = new FixedSizeStack(6);
        String string = "1+2+[(2+7+{2+2}+8)+6+2+4]";
        try {
            char[] chars = string.toCharArray();
            for (char char1 : chars) {
                if (char1 == '(') {
                    fixedSizeStack.push('(');
                } else if (char1 == '{') {
                    fixedSizeStack.push('{');
                } else if (char1 == '[') {
                    fixedSizeStack.push('[');
                }
                if (fixedSizeStack.peek() != null) {
                    if (char1 == ')') {
                        if ((Character) fixedSizeStack.peek() == '(') {
                            fixedSizeStack.poll();
                        } else {
                            System.out.println("неправильно!");
                            break;
                        }
                    } else if (char1 == '}') {
                        if ((Character) fixedSizeStack.peek() == '{') {
                            fixedSizeStack.poll();
                        } else {
                            System.out.println("неправильно!");
                            break;
                        }
                    } else if (char1 == ']') {
                        if ((Character) fixedSizeStack.peek() == '[') {
                            fixedSizeStack.poll();
                        } else {
                            System.out.println("неправильно!");
                            break;
                        }
                    }

                }

            }
            if (fixedSizeStack.peek() == null) {
                System.out.println("все верно!");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
