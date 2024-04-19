package org.example.data.access.classes;

import org.example.data.access.utility.QueryType;

/**
 * @author L7aur
 */
public class Statement {
    private StringBuilder query;
    private final QueryType queryType;

    public Statement(QueryType type) {
        this.query.append(type.toString());
        this.queryType = type;
    }

    public void createQuery() {
        switch (queryType){
            case SELECT:
                query.append("* FROM ");
                //todo
                break;
            case DELETE:
                //todo
                break;
            case INSERT:
                query.append(" INTO ");
                //todo
                break;
            case UPDATE:
                //todo
                break;
            default:
                System.out.println("<DEBUG> You should not be here!");
                break;
        }
    }

    @Override
    public String toString(){
        return query.toString();
    }
}
