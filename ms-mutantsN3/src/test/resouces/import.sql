create table mutants (id bigint primary key not null, dna varchar(255));
create table statistics (id bigint primary key not null, count_human_dna integer, count_mutant_dna integer, ratio double precision);
INSERT INTO statistics (id, count_mutant_dna, count_human_dna, ratio) VALUES (1, 1, 2, 1.0);
INSERT INTO mutants (id, dna) VALUES (1, 'ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG');