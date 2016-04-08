package ru.kpfu.itis.group11506.linked.lists;

public class CycleDetermination {

    /**
     * Возвращает true, если есть цикл. В противном случае возвращает false
     *
     * @return
     */
    public boolean hasCicle(LinkedNodes<Boolean> nodes) {
        if (nodes.getStartNode() != null) {
            if (nodes.getLastNode() != nodes.getStartNode()) {

                Node<Boolean> checkNode = nodes.getStartNode();

                while (!checkNode.getValue()) {
                    checkNode.setValue(true);
                    checkNode = checkNode.getNextNode();

                    if (checkNode == null) {
                        nodes = pasteFalses(nodes);
                        return false;
                    }
                }
                nodes = pasteFalses(nodes);
                return true;
            }
            nodes = pasteFalses(nodes);
            return nodes.getLastNode().getNextNode() == nodes.getStartNode();

        }
        return false;
    }

    private LinkedNodes<Boolean> pasteFalses(LinkedNodes<Boolean> nodes) {
        Node<Boolean> checkNode = nodes.getStartNode();
        while (checkNode.getValue()) {
            checkNode.setValue(false);
            checkNode = checkNode.getNextNode();

            if (checkNode == null) {
                break;
            }
        }
        return nodes;
    }


}
