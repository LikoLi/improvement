# HTTP Client(https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)

## File Suffix
> .http
> .rest

## Feature
- Code highlighting
- Code completion for hosts, method types, and header fields
- Code folding for requests, their parts, and response handler scripts(代码折叠)
- Inline documentation for request header fields and doc tags(内联文档的请求头字段和文档标签)
- Viewing a structure of HTTP requests(查看Http请求的结构)
- Language injections inside the request message body(请求消息体中的语言注入)
- Move refactorings
- Live templates

## Create HTTP request file

You can work with HTTP requests either from scratch files or from physical files of the HTTP Request type. Each file can contain multiple requests, and you can create as many files as needed.
1. scratch file(临时草稿文件)
    - Press `⇧⌘N` and select **HTTP Request**
2. physical file(物理文件)
    - In the `File` menu, point to `New`, and then click `HTTP Request`.
    
## Compose HTTP requests

    
## Syntax
```http request
Method Request-URI HTTP-Version
Header-field: Header-value

Request-Body
```

## Use response handler scripts
- To insert the script in-place , prepend it with `>` and enclose it in `{% %}`
```http request
GET host/api/test

> {% 
 // Response Handler Script
 %}}
```

- To insert the script from an external file, prepend it whit `>`:
```http request
GET host/api/test

> scripts/my-script.js

```

The `HTTP Response Handler` library exposes two objects to be used for composing response handler scripts:

- The `client` object stores the session metadata, which can be modified inside the script. The `client` state is preserved until you close IntelliJ IDEA. Every variable saved in `client.global` as `variable_name` is accessible to subsequent HTTP requests as `{{variable_name}}`.

- `response` holds information about the received response: its content type, status, response body, and so on.

## Execute HTTP requests
1. if you are going to test your own web service, make sure it is deployed and running.
2. Do any of the following.
    - In the editor, click The Run button in the gutter next to the request you want to execute. From the list, select Run <request name>.
      
    - In the editor, select Run <request name> from the request's context menu.
      
    - Position the caret at the request you want to execute, press ⌥⏎ and select the Run <request name> intention action.
      
    - If you have multiple HTTP requests defined in an .http file, you can run all of them sequentially. To do this, use the corresponding Run All Requests in File shortcut link on top of the request's editor panel.