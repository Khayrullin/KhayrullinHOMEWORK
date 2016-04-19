package ru.kpfu.itis.group11506.binaryTree;

import java.util.Iterator;

class BynaryTree<T extends Comparable> implements Iterable<Node<T>> {

    private Node<T> head;
    private Node<T> max;
    private Node<T> max2;
    private Node<T> min;
    private T thing1;
    private boolean checker;
    private Node<T> ourNode2;


    void addThing(T thing) {
        adder(head, thing);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new TreeIterator<>(head);
    }

    private void adder(Node<T> head, T thing) {
        if (head == null) {
            this.head = new Node<>(thing);
        } else {
            int compare = thing.compareTo(head.getThing());
            if (compare == 1 || compare == 0) {
                if (head.getR() != null) {
                    adder(head.getR(), thing);
                } else {
                    head.setR(new Node<>(thing));
                    head.getR().setParent(head);
                }
            } else {
                if (head.getL() != null) {
                    adder(head.getL(), thing);
                } else {
                    head.setL(new Node<>(thing));
                    head.getL().setParent(head);
                }
            }
        }
    }

    boolean contains(T thing) {
        Iterator<Node<T>> it = iterator();
        while (it.hasNext()) {
            if ((it.next().getThing()).equals(thing)) {
                return true;
            }
        }
        return false;
    }

    boolean remove(T thing) {
        if (contains(thing)) {
            Iterator<Node<T>> it = iterator();
            while (it.hasNext()) {
                Node<T> ourNode = it.next();
                if (ourNode.getThing().equals(thing)) {

//Удаление элемента без детей:

                    if (ourNode.getR() == null && ourNode.getL() == null
                            && ourNode.getParent() != null) {
                        if (ourNode.getThing().compareTo(ourNode.getParent().getThing()) == -1) {
                            ourNode = ourNode.getParent();
                            ourNode.setL(null);
                        } else {
                            ourNode = ourNode.getParent();
                            ourNode.setR(null);
                        }
//Удаление элемента с одним ребенком:

                    } else if (((((ourNode.getR() != null && ourNode.getL() == null)) && (ourNode.getR().getR() == null
                            && ourNode.getR().getL() == null)) || (((ourNode.getR() == null && ourNode.getL() != null)
                            && (ourNode.getL().getR() == null && ourNode.getL().getL() == null)))) &&
                            ourNode.getParent() != null) {
                        int j = ourNode.getThing().compareTo(ourNode.getParent().getThing());
                        if (ourNode.getL() != null && j == -1) {
                            ourNode = ourNode.getParent();
                            ourNode.setL(ourNode.getL().getL());
                            ourNode.getL().setParent(ourNode);
                        } else if (ourNode.getL() != null && ((j == 1) || (j == 0))) {
                            ourNode = ourNode.getParent();
                            ourNode.setR(ourNode.getR().getL());
                            ourNode.getR().setParent(ourNode);
                        } else if (ourNode.getR() != null && j == -1) {
                            ourNode = ourNode.getParent();
                            ourNode.setL(ourNode.getL().getR());
                            ourNode.getL().setParent(ourNode);
                        } else if (ourNode.getR() != null && ((j == 1) || (j == 0))) {
                            ourNode = ourNode.getParent();
                            ourNode.setR(ourNode.getR().getR());
                            ourNode.getR().setParent(ourNode);
                        }

//Удаление элемента с только одним ребенком и это КОРЕНЬ :

                    } else if (((((ourNode.getR() != null && ourNode.getL() == null)) && ((ourNode.getR().getR() != null
                            || ourNode.getR().getL() != null))) || (((ourNode.getR() == null && ourNode.getL() != null)
                            && (ourNode.getL().getR() != null || ourNode.getL().getL() != null)))) &&
                            ourNode.getParent() != null) {

                        if (ourNode.getL() != null) {
                            setMax(ourNode.getL());
                            int j = ourNode.getThing().compareTo(ourNode.getParent().getThing());
                            if (max.equals(ourNode.getL())) {
                                if(j == 1 || j ==0){
                                    ourNode.getParent().setR(max);
                                }else {
                                    ourNode.getParent().setL(max);
                                }
                                max.setParent(ourNode.getParent());

                            } else if (max.getL() != null) {
                                max.getL().setParent(max.getParent());
                                max.getParent().setR(max.getL());
                                ourNode.setThing(max.getThing());

                            } else {
                                max.getParent().setR(null);
                                ourNode.setThing(max.getThing());

                            }


                        } else if (ourNode.getR() != null) {
                            setMin(ourNode.getR());
                            int j = ourNode.getThing().compareTo(ourNode.getParent().getThing());
                            if (min.equals(ourNode.getR())) {
                                if(j == 1 || j ==0){
                                    ourNode.getParent().setR(min);
                                }else {
                                    ourNode.getParent().setL(min);
                                }
                                min.setParent(ourNode.getParent());

                            } else if (min.getR() != null) {
                                min.getR().setParent(min.getParent());
                                min.getParent().setL(min.getR());
                                ourNode.setThing(min.getThing());

                            } else {
                                min.getParent().setL(null);
                                ourNode.setThing(min.getThing());

                            }

                        }
                    }else {
                        if (!checker){
                            checker = true;
                            ourNode2 = ourNode;
                        }
                        setMax2(ourNode.getL());
                        thing1 = max2.getThing();
                        remove(max2.getThing());
                    }
                    if(thing1!= null){
                        if (thing1.equals(thing)){
                            ourNode2.setThing(thing1);
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void setMax(Node<T> max) {
        this.max = max;
        while (this.max.getR() != null) {
            this.max = this.max.getR();
        }
    }
    private void setMax2(Node<T> max) {
        this.max2 = max;
        while (this.max2.getR() != null) {
            this.max2 = this.max2.getR();
        }
    }
    private void setMin(Node<T> min) {
        this.min = min;
        while (this.min.getL() != null) {
            this.min = this.min.getL();
        }
    }
}
