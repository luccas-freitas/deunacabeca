package com.deunacabeca.api.command;

import lombok.Data;

@Data
class AbstractCommand {
    private int page = 0;
    private int size = 10;
}
