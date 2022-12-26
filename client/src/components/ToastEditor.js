import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';

const ToastEditor = () => {
  return (
    <Editor
      initialValue=" "
      previewStyle="vertical"
      minheight="300px"
      height="auto"
      initialEditType="wysiwyg"
      useCommandShortcut={false}
      hideModeSwitch={true}
      toolbarItems={[
        ['heading', 'bold', 'italic', 'code'],
        ['link', 'quote', 'codeblock', 'image', 'table'],
        ['ol', 'ul', 'hr'],
      ]}
    />
  );
};

export default ToastEditor;
