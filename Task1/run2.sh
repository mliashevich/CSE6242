hadoop jar ./target/task1-1.0.jar EntryPoint /user/cse6242/graph2.tsv /user/cse6242/task1output2
hadoop fs -getmerge /user/cse6242/task1output2/ task1output2.tsv
hadoop fs -rm -r /user/cse6242/task1output2
