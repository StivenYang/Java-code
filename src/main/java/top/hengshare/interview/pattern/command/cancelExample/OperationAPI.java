package top.hengshare.interview.pattern.command.cancelExample;

public interface OperationAPI {

    int getResult();

    void setResult(int result);

    void add(int num);

    void substract(int num);
}
