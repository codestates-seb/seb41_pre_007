/* eslint-disable react/prop-types */
import { Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';

const ToastViewer = ({ contents }) => {
  return <>{contents && <Viewer initialValue={contents} />}</>;
};

export default ToastViewer;
